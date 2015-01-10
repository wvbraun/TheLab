#include "Miner.h"



void Miner::Update()
{
	++m_iThirst;

	if (m_pCurrentState)
	{
		m_pCurrentState->Execute(this);
	}
}

void Miner::ChangeState(State* pNewState)
{
	// make sure both states are valid before attempting
	// to call their methods
	assert (m_pCurrentState && pNewState);

	// call the exit method of the existing state
	m_pCurrentState->Exit(this);

	m_pCurrentState = pNewState;

	m_pCurrentState->Enter(this);
}
