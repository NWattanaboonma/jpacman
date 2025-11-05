package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * This is a test class for MapParser.
 */
@ExtendWith(MockitoExtension.class)
public class MapParserTest {
    @Mock
    private BoardFactory boardFactory;
    @Mock
    private LevelFactory levelFactory;

    /**
     * Test for the parseMap method (good map).
     */
    @Test
    public void testParseMapGood() {
        // Arrange
        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        ArrayList<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P.G        #");
        map.add("############");

        // Act
        var level = mapParser.parseMap(map);

        // Assert
        assertNotNull(level, "Level should not be null after parsing a valid map");

        // Verify that the correct number of objects are created.
        verify(levelFactory, times(1)).createGhost();
        verify(boardFactory, times(1)).createBoard(Mockito.any());
        verify(levelFactory, times(1)).createLevel(Mockito.any(), Mockito.any(), Mockito.any());
    }

    /**
     * Test that parsing a map with inconsistent row widths throws an exception.
     */
    @Test
    public void testParseMapWrong1() {
        // Arrange
        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        ArrayList<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P.G#");
        map.add("############");

        // Act & Assert
        assertThrows(PacmanConfigurationException.class, () -> {
            mapParser.parseMap(map);
        });
    }
}
