package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.model.Window;
import com.epam.jwd.lectures.repository.GeneralStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StorageWindowServiceTest {

    private static final Answer<Boolean> FIRST_TRUE_THEN_FALSE = new Answer<Boolean>() {
        private int count;

        @Override
        public Boolean answer(InvocationOnMock invocation) {
            return count++ == 0;
        }
    };

    @Mock
    private GeneralStorage<Window> storage;

    @InjectMocks
    private StorageWindowService service;

//    @Before
//    public void setUp() throws Exception {
//        final GeneralStorage<Window> storage = new CollectionsIdEntityStorage<>();
//        service = new StorageWindowService(storage);
//
//        storage.add(new Window("first"));
//        storage.add(new Window("second"));
//        storage.add(new Window("third"));
//    }

    @Test
    public void testFindAllWindows_shouldReturnEmptyCollection_whenStorageEmpty() {
        when(storage.isEmpty()).thenReturn(true);

        final List<Window> actualWindows = service.findAllWindows();

        assertNotNull(actualWindows);
        assertTrue(actualWindows.isEmpty());
        verify(storage).isEmpty();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFindAllWindows_shouldReturnWindows_whenStorageNotEmpty() {
        Iterator<Window> iterator = mock(Iterator.class);
        final Window window = new Window("test");


        when(storage.isEmpty()).thenReturn(false);
        when(storage.iterator()).thenReturn(iterator);
        when(iterator.hasNext()).thenAnswer(FIRST_TRUE_THEN_FALSE);
        when(iterator.next()).thenReturn(window);


        final List<Window> actualWindows = service.findAllWindows();

        assertNotNull(actualWindows);
        assertFalse(actualWindows.isEmpty());
        assertEquals(1, actualWindows.size());
        assertSame(window.getType(), actualWindows.iterator().next().getType());

        verify(storage).isEmpty();
        verify(iterator, times(2)).hasNext();
        verify(iterator).next();
    }
}
