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

.SUFFIXES: .xml .pdf

.xml.pdf:
	@( cd .. ; make $@ )
	@test -f ../$@ && mv ../$@ .

all: lib/jquery-1.10.2.min.js lib/xonomy lib/Justv2.ttf lib/Justv22.ttf

general-features-selection.pdf: general-features-selection.preferences
scientific-star-chart.pdf: scientific-star-chart.preferences
artistic-star-chart.pdf: artistic-star-chart.preferences

clean:
	rm -f general-features-selection.pdf

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
