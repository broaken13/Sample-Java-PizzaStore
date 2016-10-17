function menuPrinter(id) {
    var menuRequest = new XMLHttpRequest();

    function getMenu() {
        
        menuRequest.onload = printMenu;

        menuRequest.open("GET", "http://localhost:8080/PizzaDelivery/Menu");
        menuRequest.send();
    }

    function printMenu(event) {
        var menu = JSON.parse(menuRequest.response);
        menu.forEach(createMenuDiv)
    }

    function createMenuDiv(item) {
        var div = document.createElement("div");
        div.className = "menu-item";

        var header = document.createElement("h4");
        header.innerText = item.itemName;
        header.className = "item-name";
        div.appendChild(header);

        var description = document.createElement("p");
        description.innerText = item.description;
        description.className = "item-description";
        div.appendChild(description);

        var buttonContainer = document.createElement("div");
        buttonContainer.className = "size-buttons";
        item.sizes.forEach(createSizeButton);
        div.appendChild(buttonContainer);

        document.getElementById(id).appendChild(div);

        function createSizeButton(size) {
            var button = document.createElement("button");
            button.innerText = size.sizeName + ": $" + size.sizePrice;
            button.onclick = orderSystem.addItem.bind(window, new OrderItem(item, size));
            buttonContainer.appendChild(button);
        }

        
    }

    return {
        getMenu: getMenu
    };
}

var printer = menuPrinter("menu");
printer.getMenu();
printer = null;