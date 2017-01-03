
package chartacaeli.gpu.tst;

public interface P4Projector {
//	public Coordinate forward( Coordinate lamphi ) ;
//	public Coordinate inverse( Coordinate xy ) ;
	public void init( double lam0, double phi1, double R, double k0 ) ;
	public void forward( double lamphi[], double xy[] ) ;
	public void inverse( double xy[], double lamphi[] ) ;
}
