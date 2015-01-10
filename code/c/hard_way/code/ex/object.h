// if not defined, checks if there is already a #define _object_h file and if there is it skips code. 
// Do this so we can include it in any file 
#ifndef _object_h 

// add the _object_h define so that any attempts to include 
// it later causes it to skip. 
#define _object_h

typedef enum{
	NORTH, SOUTH, EAST, WEST 
} Direction; 

typedef struct {
	char *description;
	int (*init)(void *self);
	void (*describe)(void *self);
	void (*destroy)(void *self);
	void (*move)(void *self, Direction direction);
	int (*attack)(void *self, int damage);
} Object;

int Object_init(void *self);
void Object_destroy(void *self);
void Object_describe(void *self);
void *Object_move(void *self, Direction direction);
int Object_attack(void *self, int damage);
void *Object_new(size_t size, Object proto, char *description);

//this makes a macro, and it works like a template function
//that spits out the code on the right whenever you 
//write use the macron on the left. 
//This one makes a short version of the normal way to call 
//Object_new. 
//The T and N parameters to NEW are injected into the line 
//of code on the right. The Syntax T##Proto says to 
// "concat Proto at the end of T" so if you had 
// New(Room, "Hello.") then itd make RoomProto there. 
#define NEW(T, N) Object_new(sizeof(T), T##Proto, N)

// this macro helps you write object->proto.blah as just 
// obj->_(blah)
#define _(N) proto.N

#endif
