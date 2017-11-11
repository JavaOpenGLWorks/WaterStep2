package waterRendering;

import shaders.ShaderProgram;
import shaders.UniformFloat;
import shaders.UniformMatrix;
import utils.MyFile;

public class WaterShader extends ShaderProgram {

	private static final MyFile VERTEX_SHADER = new MyFile("waterRendering", "waterVertex.glsl");
	private static final MyFile FRAGMENT_SHADER = new MyFile("waterRendering", "waterFragment.glsl");

	protected UniformMatrix projectionViewMatrix = new UniformMatrix("projectionViewMatrix");
	protected UniformFloat height = new UniformFloat("height");

	public WaterShader() {
		super(VERTEX_SHADER, FRAGMENT_SHADER);
		super.storeAllUniformLocations(projectionViewMatrix, height);
	}


}
