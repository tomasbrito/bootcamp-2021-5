package selenium;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        atc01_busquedaProductoExistenteEdge.class,
        atc01_busquedaProductoExistenteFirefox.class,
        atc01_busquedaProductoExistenteChrome.class
})

public class act01TestSuite {
}
