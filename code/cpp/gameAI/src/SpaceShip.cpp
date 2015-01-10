class SpaceShip
{
	private:
		vector m_Position;
		vector m_Velocity;
		vector m_fMass;

	public:
		void Update(float TimeElapsedSinceLastUpdate, float ForceOnShip)
		{
			float acceleration = ForceOnShip  / m_fMass;
			m_Velocity        += acceleration * TimeElapsedSinceLastUpdate;
			m_Position        += m_Velocity   * TimeElapsedSinceLastUpdate;

};
