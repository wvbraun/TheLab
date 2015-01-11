class EnterMineAndDigForNugget : public State
{
private:

	EnterMineAndDigForNugget(){}

	EnterMineAndDigForNugget(const EnterMineAndDigForNugget &);
	EnterMineAndDigForNugget& operator=(const EnterMineAndDigForNugget &);
	
public:

	static EnterMineAndDigForNugget* Instance();

	virtual void Enter(Miner* pMiner);

	virtual void Execute(Miner* pMiner);

	virtual void Exit(Miner* pMiner);
};

