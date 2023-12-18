make: 
	g++ main.cpp
	./a.exe
	rm a.exe

run: 
	./a.exe

clean:
	rm a.exe