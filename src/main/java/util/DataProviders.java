package util;

import models.Category;
import models.Order;
import models.Pet;
import models.Tag;

public class DataProviders {
    public Object[][] getNewPetSpicesCreated() {
        return new Object[][]{
                {new Pet(
                        7852255,
                        new Category(1, "Imaginary"),
                        "Fairy",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                        "available"
                )
                },
                {new Pet(
                        589878,
                        new Category(11, "Cool"),
                        "SuperDogie",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(23, "Childhood")},
                        "available"
                )
                },
                {new Pet(
                        58988578,
                        new Category(111, "Real"),
                        "Snake",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(2, "Nasty")},
                        "available"
                )
                },
                {new Pet(
                        20221,
                        new Category(1, "Pegasus"),
                        "Valkyrie",
                        new String[]{"https://www.helpfulhorsehints.com/wp-content/uploads/white-pegasus-768x512.jpg"},
                        new Tag[]{new Tag(3, "Mystery creatures")},
                        "available"
                )
                },
                {
                        new Pet(
                                20222,
                                new Category(2, "Unicorn"),
                                "Sparky Daydreamer",
                                new String[]{"https://i.pinimg.com/originals/a3/c9/0e/a3c90e5b792d65dc17fce0c2e1f12a6c.png"},
                                new Tag[]{new Tag(3, "Mystery creatures")},
                                "available"
                        )
                },
                {
                        new Pet(
                                20223,
                                new Category(3, "Snake-Turtle"),
                                "Hiragana",
                                new String[]{"https://www.everythingreptiles.com/wp-content/uploads/2020/07/Pet-Turtle-Names.jpg"},
                                new Tag[]{new Tag(1, "Reptile")},
                                "available"
                        )
                }
        };
    }

    public Object[][] getNewPendingPet() {
        return new Object[][]{
                {new Pet(
                        785228555,
                        new Category(1, "Cat1"),
                        "Ferret",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                        "pending"
                )
                },
                {new Pet(
                        58978878,
                        new Category(11, "Cool"),
                        "Parrot",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(23, "Cat2")},
                        "pending"
                )
                }
        };
    }

    public Object[][] getNewPetToBeUpdated() {
        return new Object[][]{
                {new Pet(
                        7852255,
                        new Category(1, "Imaginary"),
                        "Brontosaurus",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                        "available")
                }
        };
    }

    public Object[][] getOrderList() {
        return new Object[][]{
                {new Order(
                        1,
                        10,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "sold",
                        true
                )},
                {new Order(
                        2,
                        11,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "pending",
                        true
                )},
                {new Order(
                        3,
                        12,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )},
                {new Order(
                        4,
                        15,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "sold",
                        true
                )},
                {new Order(
                        5,
                        16,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "pending",
                        true
                )},
                {new Order(
                        6,
                        17,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )},
                {new Order(
                        7,
                        147,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )},
                {new Order(
                        8,
                        19,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "sold",
                        true
                )},
                {new Order(
                        9,
                        141,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "pending",
                        true
                )},
                {new Order(
                        10,
                        121,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )}
        };
    }

    public Object[][] getSingleOrder() {
        return new Object[][]{
                {new Order(
                        15,
                        555,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "TestMike",
                        true)
                }
        };
    }
}