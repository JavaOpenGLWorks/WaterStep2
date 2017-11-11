package waterRendering;

import org.lwjgl.opengl.GL11;

import rendering.ICamera;
import rendering.Light;
import water.WaterTile;

public class WaterRenderer {

	private final WaterShader shader;

	public WaterRenderer() {
		this.shader = new WaterShader();
	}

	public void render(WaterTile water, ICamera camera, Light light) {
		prepare(water, camera, light);
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, water.getVertexCount());
		finish(water);
	}

	public void cleanUp() {
		shader.cleanUp();
	}

	private void prepare(WaterTile water, ICamera camera, Light light) {
		water.getVao().bind();
		prepareShader(water, camera, light);
	}

	private void finish(WaterTile water) {
		water.getVao().unbind();
		shader.stop();
	}
	
	private void prepareShader(WaterTile water, ICamera camera, Light light){
		shader.start();
		loadCameraVariables(camera);
		shader.height.loadFloat(water.getHeight());
	}

	private void loadCameraVariables(ICamera camera){
		shader.projectionViewMatrix.loadMatrix(camera.getProjectionViewMatrix());
	}


}
