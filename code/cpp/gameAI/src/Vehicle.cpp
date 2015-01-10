class Vehicle
{
	vector m_vPosition;

	vector m_vVelocity;

	public:

	void Update(float TimeElapsedSinceLastUpdate)
	{
		m_vPosition += m_vVelocity * TimeElapsedSinceLastUpdate;
	}
};
