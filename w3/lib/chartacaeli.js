window.addEventListener('load', init) ;

function init(event) {
	initXonDiv('ccXonDiv') ;
}

/* init Xonomy */
function initXonDiv(id) {
	var xonDiv = document.getElementById(id) ;
	Xonomy.setMode("laic") ;
	Xonomy.render(chartS11N.defdef, xonDiv, chartS11N.Xonomy) ;

	chartStat.fresh = true ;
	chartStat.dirty = false ;
}

/* register events */
document.addEventListener('DOMContentLoaded', function(event) {

	/* addEventListener doesn't work with Bootstrap (SO #24211185) */
	$('#ccGalleryCarousel').on('slid.bs.carousel', updateBtnHref) ;

	document.addEventListener('scroll', fadeCaptionOutro ) ;

	document.addEventListener('click', closeBurgerMenu ) ;
	var a = document.querySelectorAll('a') ;
	for (var i=0 ; a.length>i ; i++ ) {
		a[i].addEventListener('click', smoothScrollToAnchor) ;
	}
	document.querySelector('#ccBtnEdit').addEventListener('click', btnEdit) ;
	document.querySelector('.navbar-toggler').addEventListener('click', btnMenu) ;
	document.querySelector('#ccBtnNew').addEventListener('click', btnNew) ;
	document.querySelector('#ccBtnLoad').addEventListener('click', btnLoad) ;
	document.querySelector('#ccBtnExec').addEventListener('click', btnExec) ;
	document.querySelector('#ccBtnSave').addEventListener('click', btnSave) ;
	document.querySelector('#ccBtnLast').addEventListener('click', btnLast) ;
}) ;

function btnLast(event) {
}

function btnSave(event) {
	$('#ccBtnLast').prop('disabled', false) ;
}

function btnExec(event) {
}

function btnLoad(event) {
}

function btnNew(event) {
	if (!chartStat.fresh) {
		initXonDiv('ccXonDiv') ;
		$('#ccBtnExec').prop('disabled', true) ;
		$('#ccBtnSave').prop('disabled', true) ;
	}
}

/* toggle burger and cross icons */
function btnMenu(event) {
	$(this).find('i').toggleClass('fa-bars fa-times');
}

/* load composer with files from data-edit- attributes of active carosuel item */
function btnEdit(event) {
	var chart = $('.carousel .active').attr('data-edit-chart') ;
	var prefs = $('.carousel .active').attr('data-edit-prefs') ;
}

function smoothScrollToAnchor(event) {
		if (this.hash !== "") {
			var hash = this.hash ;
			event.preventDefault() ;
			$('html, body').animate({ scrollTop: $(this.hash).offset().top }, 800, function() { window.location.hash = hash ; }) ;
		}
}

/* close open burger menu on any click */
function closeBurgerMenu(event) {
	var clickedOn = $(event.target) ;
	var navOpened = $('.navbar-collapse').hasClass('show') ;
	if (navOpened === true && !clickedOn.hasClass('navbar-toggler')) {
		$('.navbar-toggler').click() ;
	}
}

/* fade button at bottom of home on scroll */
function fadeCaptionOutro(event) {
	$('.caption-outro').css('opacity', 1-$(window).scrollTop()/480) ;
}

/* update href of VIEW and INFO buttons from data- attributes of active carousel item */
function updateBtnHref(event) {
	var view = $('.carousel .active').attr('data-view') ;
	document.getElementById('ccBtnView').href = view ;
	var info = $('.carousel .active').attr('data-info') ;
	document.getElementById('ccBtnInfo').href = info ;
}
