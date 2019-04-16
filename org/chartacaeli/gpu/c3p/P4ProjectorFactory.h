#ifndef __P4PROJECTORFACTORY_H__
#define __P4PROJECTORFACTORY_H__

#include <map>
#include <string>

#include "P4Projector.h"

#define P4PROJECTOR_CDEC(CNAM) \
	static P4ProjectorDerived<CNAM> p4reg
#define P4PROJECTOR_CDEF(CNAM) \
	P4ProjectorDerived<CNAM> CNAM::p4reg(#CNAM)

typedef std::map<std::string, P4Projector*(*)()> p4map_t;

struct P4ProjectorFactory {

	static P4Projector* createInstance( const std::string& cnam ) {
		p4map_t::iterator p4map_i = getP4Map()->find( cnam ) ;
		if ( p4map_i == getP4Map()->end() )
			return 0 ;
		return p4map_i->second() ;
	}

protected:
	static p4map_t* getP4Map() {
		if ( ! p4map )
			p4map = new p4map_t ;
		return p4map ;
	}

private:
	static p4map_t* p4map ;
} ;

template<typename T>
P4Projector* createT() { return new T ; }

template<typename T>
struct P4ProjectorDerived : P4ProjectorFactory {
	P4ProjectorDerived( const std::string& cnam ) {
		getP4Map()->insert( std::make_pair( cnam, &createT<T>) ) ;
	}
} ;

#endif // __P4PROJECTORFACTORY_H__
