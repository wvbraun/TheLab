package tests.interview;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.interview.general.*;

@RunWith(Suite.class)
@SuiteClasses({ ArrayTest.class,
				GeneralTest.class,
				StringsTest.class
})

public class AllTests 
{

}
