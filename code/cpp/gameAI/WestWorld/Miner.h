#include "BaseGameEntity.h"

class Miner : public BaseGameEntity
{
private:

	// a pointer to an instance of a State
	State* 		  m_pCurrentState;

	// the place where the miner is currently situated
	location_type m_Location;

	//how many nuggets the miner has in his pockets
	int			  m_iGoldCarried;

	// how much money the miner has deposited in the bank
	int 		  m_iMoneyInBank;

	// the higher the value, the thirstier the miner
	int 		  m_iThirst;

	// the higher the value, the more tired the miner
	int  		  m_iFatigue;

public:
	
	Miner(int ID);

	void Update();

	void ChangeState(State *pNewState);

};
