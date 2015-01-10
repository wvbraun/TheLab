
struct Vector2D
{
	double x;
	double y;

	Vector2D():x(0.0),y(0.0){}
	Vector2D(double a, double b):x(a),y(b){}

	// set x and y to zero
	inline void     Zero();

	inline bool     isZero()const;

	inline double   Length()const;

	inline double   LengthSq()const;

	inline void     Normalize();

	inline double   Dot(const Vector2D& v2)const;

	inline int      Sign(const Vector2D& v2)const;

	inline Vector2D Perp()const;

	inline void     Truncate(double max);

	inline double   Distance(const Vector2D &v2);

	inline double   DistanceSq(const Vector2D &v2);

	inline Vector2D GetReverse()const;

	const Vector2D& operator+=(const Vector2D &rhs);
	const Vector2D& operator-=(const Vector2D &rhs);
	const Vector2D& operator*=(const double& rhs);
	const Vector2D& operator/=(const double& rhs);

	bool operator==(const Vector2D& rhs)const;
	bool operator!=(const Vector2D& rhs)const;
};
