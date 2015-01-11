#include "EnterMineAndDigForNugget.h"

class EnterMineAndDigForNugget
{


	void EnterMineAndDigForNugget::Enter(Miner* pMiner)
	{
		// if the miner is not already locatd at the gold mine,
		// he must change location to the gold mine
		if (pMiner->Location() != goldmine)
		{
			cout << "\n" << GetNameOfEntity(pMiner->ID()) << ": "
				 << "Walking to the gold mine";

			pMiner->ChangeLocatin(goldmine);
		}
	}

}
