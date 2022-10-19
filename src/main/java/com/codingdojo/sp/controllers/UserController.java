package com.codingdojo.sp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.sp.models.LoginUser;
import com.codingdojo.sp.models.MessageEmail;
import com.codingdojo.sp.models.Photo;
import com.codingdojo.sp.models.User;
import com.codingdojo.sp.models.UsersDogs;
import com.codingdojo.sp.photo.service.PhotoService;
import com.codingdojo.sp.services.BreedsService;
import com.codingdojo.sp.services.EmailService;
import com.codingdojo.sp.services.UserDogsService;
import com.codingdojo.sp.services.UserService;
import com.codingdojo.sp.services.qPhotoService;

@Controller
public class UserController {
	
	@Autowired
	private UserService user;
	@Autowired
	private BreedsService breedServ;
	@Autowired
	private UserDogsService uDogServ;
	@Autowired
	private PhotoService pService;
	@Autowired
	private qPhotoService qphotoService;
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			model.addAttribute("dogs", uDogServ.findLastDogs());
			return "indexLogOut.jsp";
			
		}else {
			model.addAttribute("dogs", uDogServ.findLastDogs());
			return "index.jsp";
		}
	}
	@GetMapping("/login")
	public String login(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "redirect:/";
			}else {
				model.addAttribute("createLogin", new LoginUser());
				return "login.jsp";
				}
		}
	
	@GetMapping("/new_user")
	public String register(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "redirect:/";
			}else {
				model.addAttribute("createUser", new User());
				return "register.jsp";
				}
		}
	
	@PostMapping("/register_user")
	public String registerNewUser(@Valid @ModelAttribute("createUser")User createUser,
			BindingResult result, Model model, HttpSession session) {
		User newUser = user.registerUser(createUser, result);
	    if(result.hasErrors()) {
	        return "register.jsp";
	        }
	    session.setAttribute("id", newUser.getId());
	    return "redirect:/allDogs";
	    }
	
	@PostMapping("/login_user")
	public String loginUser( 
			@Valid @ModelAttribute("createLogin") LoginUser createLogin, BindingResult result, 
			Model model, HttpSession session) {
		User logUser = user.loginUser(createLogin, result);
		if(result.hasErrors()) {
	        return "login.jsp";
	        }
	    session.setAttribute("id", logUser.getId());
	    return "redirect:/allDogs";
	    }
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.setAttribute("id", null);
	    return "redirect:/";
	    }
	@GetMapping("/allDogs")
	public String dash(Model model, HttpSession session) {
		model.addAttribute("breeds", breedServ.getAllBreeds());
		model.addAttribute("dogs", uDogServ.findAll());
	    return "dashboard.jsp";
	    }
	@GetMapping("/allDogs/{id}")
	public String serchDash(Model model, @PathVariable("id") Long id, HttpSession session) {
		model.addAttribute("breeds", breedServ.getAllBreeds());
		model.addAttribute("dogs", uDogServ.findDogsByBreedID(id));
	    return "dashboard.jsp";
	    }
	
	@GetMapping("/addDog")
	public String addDog(
			Model model,
			@ModelAttribute("createDog")UsersDogs createDog,
			HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/login";
			}else {
				model.addAttribute("user_id", (Long)session.getAttribute("id"));
				model.addAttribute("breeds", breedServ.getAllBreeds());
				return "addDog.jsp";
				}
		}
				
	@PostMapping("/newDog")
	public String newDog(Model model,@Valid @ModelAttribute("createDog") UsersDogs createDog,
			@RequestParam ("imageFile")MultipartFile imageFile, 
			BindingResult result, HttpSession session) {
		String returnValue = "dashboard.jsp";
		if(result.hasErrors()) {
	        return "redirect:/";
	        }
		
		try {
			Photo photo = new Photo();
			photo.setFileName(imageFile.getOriginalFilename());
			photo.setUsersDogs(createDog);
			pService.saveImg(imageFile, photo);
			uDogServ.createNewDog(createDog,photo, result);
			pService.save(photo);
			returnValue = "redirect:/allDogs";
		} catch (IOException e) {
			
			e.printStackTrace();
			returnValue = "redirect:/";
		}
		return returnValue;
	}
		
	@GetMapping("/dogs/{id}")
	public String dogDescription(@PathVariable("id") Long id, Model model,
			@ModelAttribute("dogs")UsersDogs dogs, HttpSession session) {
		
		UsersDogs d = uDogServ.findDogByID(id);
		List<Photo> photo = qphotoService.listAll(id);
		model.addAttribute("photo", photo);
		model.addAttribute("dog", d);
		
		if (session.getAttribute("id") == d.getUser().getId()) {
			model.addAttribute("dogs", uDogServ.findLastDogs());
			return "ownerDescription.jsp";
			
		}else {
			model.addAttribute("createEmail", new MessageEmail());
			return "dogdescription.jsp";
			}
		}
		
		
	
	@PostMapping("/sendEmail/{id}")
	public String sendEmail(@PathVariable("id") Long id,@Valid @ModelAttribute("createEmail")MessageEmail email, BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			
	        return "redirect:/dogs/{id}"; 
	        }
		String emailString = "pastushenko3495@gmail.com";
		emailService.sendEmail(emailString ,emailService.body(email, result), emailService.subject(email, result));
	    return "redirect:/sucsessEmail";
	    }
	
	@GetMapping("/sucsessEmail")
	public String Secses(HttpSession session) {
		return "emailSend.jsp";
	}
	
	@GetMapping("/dog/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,
			@ModelAttribute("editDog")UsersDogs editDog, HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/";
			} else {
				UsersDogs d = uDogServ.findDogByID(id);
				model.addAttribute("user_id", (Long)session.getAttribute("id"));
				model.addAttribute("dog", d);
				model.addAttribute("breeds", breedServ.getAllBreeds());
				return "editDog.jsp";
				}
		}
	@PutMapping("/dog/{id}/update")
	public String updateDogPost(@PathVariable("id") Long id,Model model,
			@Valid @ModelAttribute("editDog") UsersDogs editDog,
			@RequestParam ("imageFile")MultipartFile imageFile,
			BindingResult result, HttpSession session) {
		String returnValue = "dashboard.jsp";
		if(result.hasErrors()) {
			return "editDog.jsp";
	        }
		
		try {
			Photo photo = new Photo();
			photo.setFileName(imageFile.getOriginalFilename());
			photo.setUsersDogs(editDog);
			pService.saveImg(imageFile, photo);
			uDogServ.updateDog(editDog,photo, result);
			pService.save(photo);
			returnValue = "redirect:/allDogs";
		} catch (IOException e) {
			
			e.printStackTrace();
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	@RequestMapping(value="/dog/delete/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/";
			} else {
				uDogServ.deleteDog(id);
				return "redirect:/allDogs";
    }
	
}
}

