//@@author ZhangYijiong
package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.Test;

import seedu.address.logic.commands.CompleteOneOrderCommand;

public class CompleteOneOrderCommandParserTest {

    private CompleteOneOrderCommandParser parser = new CompleteOneOrderCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new CompleteOneOrderCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgsSecond_throwsParseException() {
        assertParseFailure(parser, "#",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, CompleteOneOrderCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, CompleteOneOrderCommand.MESSAGE_USAGE));
    }
}


