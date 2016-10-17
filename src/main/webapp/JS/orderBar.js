var orderSystem = (function() {
    var order = JSON.parse(localStorage.getItem("order")) || [];
    document.addEventListener('DOMContentLoaded', refreshOrderBar, false);

    function addItem(orderItem) {
        var existingItem = order.find(function (item) {
            return orderItem.id == item.id;
        });

        if (existingItem != undefined) {
            var sizeOrdered = existingItem.sizes.find(function (size) {
                return size.id ==  orderItem.sizeId;
            });

            if(sizeOrdered != undefined) {
                sizeOrdered.quantity += 1;
            } else {
                sizeOrdered = {
                    id: orderItem.sizeId,
                    sizeName: orderItem.sizeName,
                    sizePrice: orderItem.sizePrice,
                    quantity: 1
                };
                existingItem.sizes.push(sizeOrdered);
            }

        } else {
            var newItem = {
                id: orderItem.id,
                itemName: orderItem.item,
                sizes: [{
                    id: orderItem.sizeId,
                    sizeName: orderItem.sizeName,
                    sizePrice: orderItem.sizePrice,
                    quantity: 1
                }]
            }

            order.push(newItem);
        }

        localStorage.setItem("order", JSON.stringify(order));
        refreshOrderBar();
    }

    function removeItem(itemId, sizeId) {
        console.log(itemId + " " + sizeId);
        // Search for the item
        var orderItemIndex = -1;
        var orderItem = order.find((item, i) => {if(item.id == itemId){orderItemIndex = i; return true;} return false;});
        console.log(orderItem);

        // find size
        var index = -1;
        var sizeOrder = orderItem.sizes.find((size, i) =>{ 
            if(size.id == sizeId){
                index = i;
                return true;
            } 
            return false;
        });

        console.log(sizeOrder);
        console.log(index);
        // decrement quantity
        sizeOrder.quantity -= 1;
        if(sizeOrder.quantity < 1) {
            //if 0 then remove size from sizes
            orderItem.sizes.splice(index, 1);

            if(orderItem.sizes.length == 0) {
                //if sizes is empty remove item from order
                order.splice(orderItemIndex, 1);
            }
        }
             
        //repaint
        localStorage.setItem("order", JSON.stringify(order));
        refreshOrderBar();
    }

    function refreshOrderBar() {
        var orderBar = document.getElementById("order");
        orderBar.innerHTML = "";
        order.forEach(createOrderItemDiv);

        function createOrderItemDiv(item) {
            var div = document.createElement("div");
            div.className = "order-item";

            var header = document.createElement("h4");
            header.innerText = item.itemName;
            div.appendChild(header);

            var ul = document.createElement("ul");
            ul.className = "ordered-sizes";

            item.sizes.forEach(createSizeListItems);
            div.appendChild(ul);
            orderBar.appendChild(div);


            function createSizeListItems(size) {
                var li = document.createElement("li");
                li.className = "item-size";

                var firstDiv = document.createElement("div");
                firstDiv.innerText = size.sizeName;
                li.appendChild(firstDiv);

                var secondDiv = document.createElement("div");
                secondDiv.innerText = size.quantity;
                var removeButton = document.createElement("button");
                removeButton.onclick = removeItem.bind(this, item.id, size.id);
                removeButton.innerText = "X";
                secondDiv.appendChild(removeButton);
                li.appendChild(secondDiv);

                ul.appendChild(li);
            }
        }
    }

    return {addItem: addItem,
            removeItem: removeItem};

})();

function OrderItem(item, size) {
    this.id = item.id;
    this.item = item.itemName;
    this.sizeName = size.sizeName;
    this.sizePrice = size.sizePrice;
    this.sizeId = size.id;
}