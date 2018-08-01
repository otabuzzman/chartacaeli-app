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

all: lib/jquery-1.10.2.min.js lib/xonomy/xonomy.js

clean:

# local clean
lclean: clean
	rm -rf lib/xonomy

# real clean
rclean: lclean
	rm -f lib/jquery-1.10.2.min.js

tidy: rclean

lib/jquery-1.10.2.min.js:
	wget -q -O $@ https://code.jquery.com/$(@F)
lib/xonomy/xonomy.js:
	(cd lib ; git clone https://github.com/michmech/xonomy.git)
	(cd $(@D) ; git checkout 810057e13c671728d236f85579296188e93a9fb3)
