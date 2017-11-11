#version 330

const vec3 waterColour = vec3(0.604, 0.867, 0.851);

out vec4 out_colour;

void main(void){
	
	out_colour = vec4(waterColour, 1.0);

}