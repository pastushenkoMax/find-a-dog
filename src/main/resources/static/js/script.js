/**
 * 
 */
var headerBg = document.getElementById('bg')
window.addEventListener('scroll', function(){
	headerBg.style.opacity = 1 - +window.pageYOffset/550+''
	headerBg.style.top = +window.pageYOffset +'px'
	headerBg.style.backgroundPositionY = - +window.pageYOffset/2+'px'
})

function scrollDown(){
	document.getElementById('mainContent').scrollIntoView();
}