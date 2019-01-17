/* close mobile navbar on click */
$(document).ready(function() {
	$(window).click(function(event) {
		var clickedOn = $(event.target) ;
		var navOpened = $(".navbar-collapse").hasClass("show") ;
		// prevent .navbar-toggler from being clicked twice
		if (navOpened === true && !clickedOn.hasClass("navbar-toggler")) {
			$(".navbar-toggler").click() ;
		}
	}) ;
}) ;

/* smooth scroll to content sections */
$(document).ready(function() {
	// on click on any a tag...
	$("a").on('click', function(event) {
		// ...and if link contains a '#'...
		if (this.hash !== "") {
			event.preventDefault() ;
			var target = this.hash ; // keep value for callback function
			// ...smooth scroll to selected section
			$('html, body').animate(
				{ scrollTop: $(target).offset().top }, 800, function() { window.location.hash = target ; }) ;
		}
	}) ;
}) ;
