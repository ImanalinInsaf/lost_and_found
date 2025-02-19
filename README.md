First, we create the Item class, which all found items will refer to.
This class is needed to conveniently store information about an item.

Next comes the Item constructor, which creates a new item.
When someone finds an item and enters its details, this constructor generates an object.

Then, we have the getters and the claim() method, which allow us to retrieve item data.

Finally, there's the toString() method, which formats the item for display.
When we print System.out.println(item), this method determines how it looks.

Now, we create the main class LostAndFoundSystem, where all the program's logic will be.

Next, we set up the main menu.
The program runs in an infinite while (true) loop until the user decides to exit.

The addItem() function adds a new item.
The viewUnclaimedItems() function displays unclaimed items.
The searchItem() function searches for an item by keyword.
The claimItem() function marks an item as claimed.

Finally, there is an option to exit the program.
