# From $< to $@

SOURCES := $(wildcard *.cpp)
OBJECTS := ${SOURCES:.cpp=.o}
RESULTS := ${SOURCES:.cpp=.exe}

CC := clang++

CC_FLAGS := -Weverything\
     -Wno-c++98-compat-pedantic\
     -Wno-c++98-compat\
     -Wno-exit-time-destructors\
     -Wno-global-constructors\
     -std=c++17

CLEAN_CMD := del


${RESULTS}: %.exe: %.o
	@echo Linking $@
	@${CC} ${CC_FLAGS} $< -o $@

${OBJECTS}: %.o: %.cpp
	@echo Compiling $@
	@${CC} ${CC_FLAGS} -c $< -o $@

.PHONY: clean
clean:
	-${CLEAN_CMD} ${OBJECTS} ${RESULTS}
