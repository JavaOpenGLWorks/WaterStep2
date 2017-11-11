#version 330

layout(location = 0) in vec2 in_position;
layout(location = 1) in vec4 in_indicators;

uniform float height;

uniform mat4 projectionViewMatrix;

void main(void){
	
	vec3 currentVertex = vec3(in_position.x, height, in_position.y);
	gl_Position = projectionViewMatrix * vec4(currentVertex, 1.0);

}