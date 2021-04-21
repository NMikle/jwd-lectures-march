package com.epam.jwd.lectures.repository;

import com.epam.jwd.lectures.model.Window;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

@RunWith(JUnit4.class)
public class CollectionsIdEntityStorageTest {

    private final GeneralStorage<Window> storage = new CollectionsIdEntityStorage<>();

    @Before
    public void setUp() {
        System.out.println("@Before");
    }

    @After
    public void tearDown() {
        System.out.println("@After");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@AfterClass");
    }

    @Test
    public void testGet_returnsEntityWithCorrespondingId_whenEntityPresent() {
        final Window savedWindow = new Window("testWindow");

        storage.add(savedWindow);

        final Window actualWindow = storage.get(1);

        assertNotNull(actualWindow);
        assertEquals((Integer) 1, actualWindow.getId());
        assertSame(savedWindow.getType(), actualWindow.getType());
    }

    @Test
    public void testAdd_returnsEntityWithId_whenIdNull() {
        final Window windowToSave = new Window("test");
        final Window savedWindow = storage.add(windowToSave);

        assertNotNull("Id should be not null", savedWindow.getId());
        assertEquals("First object should have id 1", (Integer) 1, savedWindow.getId());
    }

//    @Test
//    public void testAdd_throwsIllegalArgumentException_whenIdNotNull() {
//        final Window windowToSave = new Window("test");
//        windowToSave.setId(1);
//
//        try {
//            storage.add(windowToSave);
//            fail();
//        } catch (IllegalArgumentException e) {
//            assertEquals("Entity id must be null", e.getMessage());
//        }
//    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testAdd_throwsIllegalArgumentException_whenIdNotNull() {
//        final Window windowToSave = new Window("test");
//        windowToSave.setId(1);
//
//        storage.add(windowToSave);
//    }

    @Test
    public void testAdd_throwsIllegalArgumentException_whenIdNotNull() {
        final Window windowToSave = new Window("test");
        windowToSave.setId(1);

        assertThrows(
                "Should have thrown IllegalArgumentException",
                IllegalArgumentException.class,
                () -> storage.add(windowToSave)
        );
    }

}
