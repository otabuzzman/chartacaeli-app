
package chartacaeli;

import edu.rit.gpu.GpuByteArray;
import edu.rit.gpu.GpuIntArray;
import edu.rit.gpu.Kernel;

public interface PJ2TextureMapperKernel extends Kernel {
	public void run(
			GpuByteArray pnam, float lam0, float phi1, float R, float k0,
			float m2p00, float m2p01, float m2p02,
			float m2p10, float m2p11, float m2p12,
			float m2p20, float m2p21, float m2p22,
			float h2t00, float h2t01, float h2t02, float h2t03,
			float h2t10, float h2t11, float h2t12, float h2t13,
			float h2t20, float h2t21, float h2t22, float h2t23,
			float h2t30, float h2t31, float h2t32, float h2t33,
			float p1x, float p1y, float p1z,
			float p2x, float p2y, float p2z,
			float p3x, float p3y, float p3z,
			int dimo, int dimp, GpuIntArray texture,
			int dims, int dimt, GpuIntArray mapping,
			float ups ) ;
}
