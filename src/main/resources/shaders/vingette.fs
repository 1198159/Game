#version 330

in vec4 pos;

out vec4 fragColor;

void main()
{
	fragColor = vec4(0, 0,0, (pos.x*pos.x + pos.y*pos.y));
}