# From $< to $@

SOURCES := $(wildcard *.cpp)
OBJECTS := ${SOURCES:.cpp=.o}
RESULT := a.exe

ADDRESS_SANITIZER := 1
DEBUG_WITH_GDB := 0

ifeq (${ADDRESS_SANITIZER}, 1)
    SANITIZER_FLAG := -fsanitize=address
    SANITIZER_EXTRAS := ${RESULT:.exe=.exp} ${RESULT:.exe=.pdb} ${RESULT:.exe=.lib}
endif

ifeq (${DEBUG_WITH_GDB}, 1)
    DEBUG_FLAGS := -O0 -g # -target x86_64-w64-mingw32
endif


CC := clang++

INCLUDES := -I${BOOST_ROOT}

CC_FLAGS := ${DEBUG_FLAGS}\
     -Weverything\
     -Wno-c++98-compat-pedantic\
     -Wno-c++98-compat\
     -Wno-exit-time-destructors\
     -Wno-global-constructors\
     -std=c++17\
     ${INCLUDES} ${SANITIZER_FLAG}

CLEAN_CMD := del


${RESULT}: ${OBJECTS}
	@echo Linking
	@${CC} ${CC_FLAGS} ${OBJECTS} -o ${RESULT}

${OBJECTS}: %.o: %.cpp
	@echo Compiling $@
	@${CC} ${CC_FLAGS} -c $< -o $@

.PHONY: clean
clean:
	-${CLEAN_CMD} ${OBJECTS} ${SANITIZER_EXTRAS} ${RESULT}
