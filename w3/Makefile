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

PDF = general-features-selection.pdf \
	scientific-star-chart.pdf \
	artistic-star-chart.pdf \
	artistic-star-chart--toppage.pdf \
	artistic-star-chart--artwork.pdf

PNG = general-features-selection.png \
	scientific-star-chart.png \
	artistic-star-chart.png \
	artistic-star-chart--toppage.png \
	artistic-star-chart--artwork.png

GNG = ccGallery_general-features-selection.png \
	ccGallery_scientific-star-chart.png \
	ccGallery_artistic-star-chart.png \
	ccGallery_artistic-star-chart--toppage.png \
	ccGallery_artistic-star-chart--artwork.png

.SUFFIXES: .xml .pdf .png

.PHONY: all clean lclean rclean tidy pdf png gng

vpath %.xml lab
vpath %.preferences lab

.xml.pdf:
	@( export _JAVA_OPTIONS=-Duser.language=en ; cd .. ; make $@ )
	@test -f ../$@ && mv ../$@ .

.pdf.png:
	$${GS:-gs} -q -o - -r150 -sDEVICE=pngalpha -sPAPERSIZE=a2 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 $< |\
	magick convert png:- -background "rgb(255,255,255)" -flatten $@

all: lib/xonomy lib/Justv2.ttf lib/Justv22.ttf pdf png gng

pdf: $(PDF)

png: $(PNG)

gng: $(GNG)

ccGallery_%.png: %.png
	magick convert $< -crop x1395+0+512 $@

general-features-selection.pdf: general-features-selection.xml general-features-selection.preferences
scientific-star-chart.pdf: scientific-star-chart.xml scientific-star-chart.preferences
artistic-star-chart--toppage.pdf: artistic-star-chart--toppage.xml artistic-star-chart--toppage.preferences
artistic-star-chart--artwork.pdf: artistic-star-chart--artwork.xml artistic-star-chart--artwork.preferences
artistic-star-chart.pdf: artistic-star-chart--toppage.pdf artistic-star-chart--artwork.pdf
	pdftk $< background artistic-star-chart--artwork.pdf output $@

$(PNG):
$(GNG):

clean:
	rm -f $(PDF) $(PNG) $(GNG)

# local clean
lclean: clean
	rm -f lib/Justv2.ttf lib/Justv22.ttf

# real clean
rclean: lclean
	rm -f lib/jquery-1.10.2.min.js
	rm -rf lib/xonomy
	rm -f lab/just.zip

tidy: rclean

lib/jquery-1.10.2.min.js:
	wget -q -O $@ https://code.jquery.com/$(@F)
lib/xonomy: lib/jquery-1.10.2.min.js
	(cd lib ; git clone https://github.com/michmech/xonomy.git)
	(cd $@ ; git checkout 810057e13c671728d236f85579296188e93a9fb3)
lab/just.zip:
	wget -P lab -q http://www.iconian.com/fonts/just.zip
lib/Justv2.ttf lib/Justv22.ttf: lab/just.zip
	unzip -qod $(@D) $< $(@F)
