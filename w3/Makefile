ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

ifdef winos
sep := ;
else
sep := :
endif

.SUFFIXES: .xml .pdf .png

.xml.pdf:
	@( export _JAVA_OPTIONS=-Duser.language=en ; cd .. ; make $@ )
	@test -f ../$@ && mv ../$@ .

.pdf.png:
	$${GS:-gs} -q -o $@ -sDEVICE=pngalpha -sPAPERSIZE=a2 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 $<

all: lib/jquery-1.10.2.min.js lib/xonomy lib/Justv2.ttf lib/Justv22.ttf

general-features-selection.pdf: general-features-selection.preferences
scientific-star-chart.pdf: scientific-star-chart.preferences
artistic-star-chart.pdf: artistic-star-chart--toppage.pdf artistic-star-chart--artwork.pdf
	pdftk $< background artistic-star-chart--artwork.pdf output $@
artistic-star-chart--toppage.pdf: artistic-star-chart--toppage.preferences
artistic-star-chart--artwork.pdf: artistic-star-chart--artwork.preferences

general-features-selection.png scientific-star-chart.png artistic-star-chart.png:

clean:
	rm -f general-features-selection.pdf scientific-star-chart.pdf artistic-star-chart.pdf
	rm -f general-features-selection.png scientific-star-chart.png artistic-star-chart.png

# local clean
lclean: clean
	rm -f lib/Justv2.ttf lib/Justv22.ttf

# real clean
rclean: lclean
	rm -f lib/jquery-1.10.2.min.js
	rm -rf lib/xonomy
	rm -f just.zip

tidy: rclean

lib/jquery-1.10.2.min.js:
	wget -q -O $@ https://code.jquery.com/$(@F)
lib/xonomy:
	(cd lib ; git clone https://github.com/michmech/xonomy.git)
	(cd $@ ; git checkout 810057e13c671728d236f85579296188e93a9fb3)
just.zip:
	wget -q http://www.iconian.com/fonts/just.zip
lib/Justv2.ttf lib/Justv22.ttf: just.zip
	unzip -qod $(@D) $< $(@F)
