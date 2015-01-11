class BaseGameEntity
{
private:
	// every entity has a unique identifying number
	int 	   m_ID;

	// this is the next valid ID. Each time a BaseGameEntity is 
	// instaniated, this value is updated
	static int m_iNextValidID;

	// this is called within the constructor to make sure the ID 
	// is set correctly. It verifies that the value passed to the
	// method is greater or equal to the next valid ID, before 
	// setting the ID and incrementing the next valid ID.
	void SetID(int val);

public:

	BaseGameEntity(int id)
	{
		SetID(id);
	}

	// a virtual constructor is used to decouple object
	// creation from it's type.
	// This ensures to invoke actual object destructor
	virtual ~BaseGameEntity(){}

	// all entities must implement an update function
	virtual void Update()=0;

	int 		 ID()const{return m_ID;};

};
