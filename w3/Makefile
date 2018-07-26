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

all: lib/jquery-1.10.2.min.js lib/xonomy-3.5.0/xonomy.js

clean:

# local clean
lclean: clean
	rm -rf lib/xonomy-3.5.0

# real clean
rclean: lclean
	rm -f xonomy.zip
	rm -f lib/jquery-1.10.2.min.js

tidy: rclean

lib/jquery-1.10.2.min.js:
	wget -q -O $@ https://code.jquery.com/$(@F)
xonomy.zip:
	wget -q http://www.lexiconista.com/Xonomy/xonomy.zip
lib/xonomy-3.5.0/xonomy.js: xonomy.zip
	unzip -uo $< -d lib
