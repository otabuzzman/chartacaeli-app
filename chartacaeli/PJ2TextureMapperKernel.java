
package chartacaeli;

import edu.rit.gpu.GpuByteArray;
import edu.rit.gpu.GpuDoubleMatrix;
import edu.rit.gpu.GpuIntMatrix;
import edu.rit.gpu.Kernel;

public interface PJ2TextureMapperKernel extends Kernel {
	public void run(
			GpuByteArray pnam,
			GpuDoubleMatrix tmM2P,
			GpuDoubleMatrix tmH2T,
			GpuDoubleMatrix spT,
			GpuIntMatrix texture,
			GpuIntMatrix mapping ) ;
}
