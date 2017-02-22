
package chartacaeli;

import edu.rit.gpu.GpuByteArray;
import edu.rit.gpu.GpuIntMatrix;
import edu.rit.gpu.Kernel;

public interface PJ2TextureMapperKernel extends Kernel {
	public void run(
			GpuByteArray pnam, double lam0, double phi1, double R, double k0,
			double m2p00, double m2p01, double m2p02,
			double m2p10, double m2p11, double m2p12,
			double m2p20, double m2p21, double m2p22,
			double h2t00, double h2t01, double h2t02, double h2t03,
			double h2t10, double h2t11, double h2t12, double h2t13,
			double h2t20, double h2t21, double h2t22, double h2t23,
			double h2t30, double h2t31, double h2t32, double h2t33,
			double p1x, double p1y, double p1z,
			double p2x, double p2y, double p2z,
			double p3x, double p3y, double p3z,
			int dimo, int dimp, GpuIntMatrix texture,
			int dims, int dimt, GpuIntMatrix mapping,
			double ups ) ;
}
