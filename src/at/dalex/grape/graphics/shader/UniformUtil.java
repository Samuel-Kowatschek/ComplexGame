package at.dalex.grape.graphics.shader;

import java.nio.FloatBuffer;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL20.*;

public interface UniformUtil {

	class UniformLoader {

		private int shaderProgramId;
		
		//createFloatBuffer(--> 16 <--); because we use a 4x4 matrix
		private FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);
		
		protected UniformLoader(int shaderProgram) {
			shaderProgramId = shaderProgram;
		}
		
		protected int getUniformLocation(String uniformName) {
			return glGetUniformLocation(shaderProgramId, uniformName);
		}
		
		protected void loadFloat(int location, float value) {
			glUniform1f(location, value);
		}
		
		protected void loadMatrix(int location, org.joml.Matrix4f matrix) {
			matrix.get(matrixBuffer);
			glUniformMatrix4fv(location, false, matrixBuffer);
		}
		
		protected void loadInt(int location, int value) {
	        glUniform1i(location, value);
	    }

	    protected void loadVector(int location, Vector3f vector) {
	        glUniform3f(location, vector.x, vector.y, vector.z);
	    }

	    protected void loadVector(int location, Vector4f vector) {
	        glUniform4f(location, vector.x, vector.y, vector.z, vector.w);
	    }

	    protected void load2DVector(int location, Vector2f vector) {
	        glUniform2f(location, vector.x, vector.y);
	    }

	    protected void loadBoolean(int location, boolean value) {
	        float toLoad = 0;
	        if (value) {
	            toLoad = 1;
	        }
	        glUniform1f(location, toLoad);
	    }
	}
}