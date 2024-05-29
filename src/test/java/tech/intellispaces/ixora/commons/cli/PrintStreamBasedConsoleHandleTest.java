package tech.intellispaces.ixora.commons.cli;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests fo {@link PrintStreamBasedConsoleHandle} class.
 */
public class PrintStreamBasedConsoleHandleTest {

  @Test
  public void testPrintStreamBasedConsoleHandle() {
    // Given
    var os = new ByteArrayOutputStream();
    var ps = new PrintStream(os, true, StandardCharsets.UTF_8);
    var handle = new PrintStreamBasedConsoleHandleImpl(ps);

    // When
    handle.sameConsoleWithLastMessageAndNewLine("abc");
    handle.sameConsoleWithLastMessage("def");

    // Then
    String output = os.toString(StandardCharsets.UTF_8);
    assertThat(output).isEqualTo("abc" + System.lineSeparator() + "def");
  }
}
