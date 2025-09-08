package cop.poe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    @BeforeEach
    public void setup() {
        // Clear the list before each test to avoid interference
        Series_ArrayList.SeriesList.seriesList.clear();
    }

    @Test
    public void testCaptureSeries() {
        Series.captureSeries("S001", "Breaking Bad", 18, "62");

        assertEquals(1, Series_ArrayList.SeriesList.seriesList.size());

        Series_ArrayList.SeriesStorage s = Series_ArrayList.SeriesList.seriesList.get(0);
        assertEquals("S001", s.seriesid);
        assertEquals("Breaking Bad", s.seriesname);
        assertEquals("18", s.seriesAgeRestriction);
        assertEquals("62", s.seriesNumberOfEpisodes);
    }

    @Test
    public void testSearchSeries_found() {
        Series.captureSeries("S002", "Loki", 13, "6");

        Series_ArrayList.SeriesStorage s = Series.searchSeries("S002");
        assertNotNull(s);
        assertEquals("Loki", s.seriesname);
    }

    @Test
    public void testSearchSeries_notFound() {
        Series_ArrayList.SeriesStorage s = Series.searchSeries("NON_EXISTENT");
        assertNull(s);
    }

    @Test
    public void testUpdateSeries_success() {
        Series.captureSeries("S003", "Friends", 13, "10");

        boolean updated = Series.updateSeries("S003", "Friends New", "14", "12");
        assertTrue(updated);

        Series_ArrayList.SeriesStorage s = Series.searchSeries("S003");
        assertEquals("Friends New", s.seriesname);
        assertEquals("14", s.seriesAgeRestriction);
        assertEquals("12", s.seriesNumberOfEpisodes);
    }

    @Test
    public void testUpdateSeries_notFound() {
        boolean updated = Series.updateSeries("NON_EXISTENT", "Name", "15", "5");
        assertFalse(updated);
    }

    @Test
    public void testDeleteSeries_success() {
        Series.captureSeries("S004", "Breaking Bad", 18, "62");

        boolean deleted = Series.deleteSeries("S004");
        assertTrue(deleted);
        assertEquals(0, Series_ArrayList.SeriesList.seriesList.size());
    }

    @Test
    public void testDeleteSeries_notFound() {
        boolean deleted = Series.deleteSeries("NON_EXISTENT");
        assertFalse(deleted);
    }

    @Test
    public void testDisplaySeriesReportLogic() {
        Series.captureSeries("S005", "Stranger Things", 16, "34");
        Series.captureSeries("S006", "The Witcher", 18, "8");

        String report = Series.displaySeriesReportLogic();

        assertTrue(report.contains("S005"));
        assertTrue(report.contains("Stranger Things"));
        assertTrue(report.contains("S006"));
        assertTrue(report.contains("The Witcher"));
    }
}
