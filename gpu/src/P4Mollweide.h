#ifndef __P4MOLLWEIDE_H__
#define __P4MOLLWEIDE_H__

class P4Mollweide {

public:
	P4Mollweide() ;
	
	void init( double lam0, double phi1, double R, double k0 ) ;
	double *forward( double lamphi[3] ) ;
	double *inverse( double xy[3] ) ;

private:
	double lam0 ;
	double R ;
	
	const double V_CON ;
	const double radperdeg ;
	const double degperrad ;
} ;

#endif // __P4MOLLWEIDE_H__
