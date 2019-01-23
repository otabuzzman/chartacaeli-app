/* register events */
document.addEventListener('DOMContentLoaded', function(event) {

	/* addEventListener doesn't work with Bootstrap (SO #24211185) */
	$('#ccGalleryCarousel').on('slid.bs.carousel', updBtnAttr) ;

	window.addEventListener('click', closeMobileNavbar ) ;
	window.addEventListener('scroll', fadeCaptionOutro ) ;
	var a = document.querySelectorAll('a') ;
	for (var i=0 ; a.length>i ; i++ ) { a[i].addEventListener('click', smoothScrollToAnchor) ; }
	document.querySelector('#ccBtnEdit').addEventListener('click', cbBtnEdit) ;

	/* update href of VIEW and INFO buttons from data- attributes of active carousel item */
	function updBtnAttr(event) {
		var view = $('.carousel .active').attr('data-view') ;
		document.getElementById('ccBtnView').href = view ;

		var info = $('.carousel .active').attr('data-info') ;
		document.getElementById('ccBtnInfo').href = "#"+info ;
	}
	function closeMobileNavbar(event) {
		var clickedOn = $(event.target) ;
		var navOpened = $('.navbar-collapse').hasClass('show') ;
		// prevent .navbar-toggler from being clicked twice
		if (navOpened === true && !clickedOn.hasClass('navbar-toggler')) {
			$('.navbar-toggler').click() ;
		}
	}
	function fadeCaptionOutro(event) {
		$('.caption-outro').css('opacity', 1-$(window).scrollTop()/480) ;
	}
	function smoothScrollToAnchor(event) {
		// if link contains a '#'...
		if (this.hash !== "") {
			event.preventDefault() ;
			var target = this.hash ; // keep value for reset
			// ...smooth scroll to selected section
			$('html, body').animate(
				{ scrollTop: $(target).offset().top }, 800, function() { window.location.hash = target ; }) ;
		}
	}
	/* load composer with files from data-edit attribute of active carosuel item */
	function cbBtnEdit(event) {
		var edit = $('.carousel .active').attr('data-edit').split(",") ;
		var chart = edit[0].trim() ;
		var prefs = edit[1].trim() ;
	}
}) ;
