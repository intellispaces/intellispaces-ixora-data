package tech.intellispaces.ixora.commons.cli;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.intellispaces.framework.core.IntellispacesFramework;
import tech.intellispaces.framework.core.annotation.Module;
import tech.intellispaces.framework.core.system.Modules;
import tech.intellispaces.ixora.commons.configuration.CliConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests fo {@link AbstractPrintStreamBasedConsole} class.
 */
@Module(units = CliConfiguration.class)
public class PrintStreamBasedConsoleTest {

  @BeforeEach
  public void init() {
    IntellispacesFramework.loadModule(PrintStreamBasedConsoleTest.class).start();
  }

  @AfterEach
  public void deinit() {
    Modules.activeModule().stop();
  }

  @Test
  public void testPrintStreamBasedConsoleHandle() {
    // Given
    var os = new ByteArrayOutputStream();
    var ps = new PrintStream(os, true, StandardCharsets.UTF_8);
    var handle = new PrintStreamBasedConsole(ps);

    // When
    handle.println("abc");
    handle.print("def");

    // Then
    String output = os.toString(StandardCharsets.UTF_8);
    assertThat(output).isEqualTo("abc" + System.lineSeparator() + "def");
  }
}
