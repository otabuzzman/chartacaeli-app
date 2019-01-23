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

.SUFFIXES: .xml .pdf .png

.PHONY: all clean lclean rclean tidy pdf png

vpath %.xml lab
vpath %.preferences lab

.xml.pdf:
	@( export _JAVA_OPTIONS=-Duser.language=en ; cd .. ; make $@ )
	@test -f ../$@ && mv ../$@ .

.pdf.png:
	$${GS:-gs} -q -o - -sDEVICE=pngalpha -sPAPERSIZE=a2 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 $< |\
	magick convert $< -background "rgb(255,255,255)" -flatten $@

all: lib/xonomy pdf png

pdf: $(PDF)

png: $(PNG)

%.pdf: %.preferences lib/Justv2.ttf lib/Justv22.ttf
artistic-star-chart.pdf: artistic-star-chart--toppage.pdf artistic-star-chart--artwork.pdf
	pdftk $< background artistic-star-chart--artwork.pdf output $@

$(PNG):

clean:
	rm -f $(PDF) $(PNG)

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
lib/xonomy: lib/jquery-1.10.2.min.js
	(cd lib ; git clone https://github.com/michmech/xonomy.git)
	(cd $@ ; git checkout 810057e13c671728d236f85579296188e93a9fb3)
just.zip:
	wget -q http://www.iconian.com/fonts/just.zip
lib/Justv2.ttf lib/Justv22.ttf: just.zip
	unzip -qod $(@D) $< $(@F)
