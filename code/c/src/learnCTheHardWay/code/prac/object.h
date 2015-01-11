#ifndef OBJECT_H
#define OBJECT_H

typedef enum  {
	NORTH, SOUTH, EAST, WEST
} Direction;

typedef struct {
	char *description;
	int (*init)(void *self);
	void (*describe)(void *self);
	void (*destroy)(void *self);
	void *(*move)(void *self, Direction direction);
	int (*attack)(void *self, int damage);
} Object;

int Object_init(void *self);
void Object_destroy(void *self);
void Object_describe(void *self);
void *Object_move(void *self, Direction direction);
int Object_attack(void *self, int damage);
void *Object_new(size_t size, Object proto, char *description);

/* this makes a macro, and it works like a template function that
 * spitsout the codeon the right, whenver you use the macro on left.
 * This makes a short version of the normal way we would call 
 * Object_new and avoids potential errors with calling it wrong. 
 * The T and N parameters to NEW are injected into the line of code
 * on the right. T##Proto says to concat Proto at the end of T, so 
 * if you had NEW(Room, "Hello") then it would make RoomProto there.*/

#define NEW(T,N) Object_new(sizeof(T), T##Proto, N)
#define _(N) proto.N

#endif
