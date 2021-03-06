package net.chrisrichardson.ftgo.orderservice.domain;

import net.chrisrichardson.ftgo.kitchenservice.api.TicketDetails;
import net.chrisrichardson.ftgo.orderservice.api.events.OrderDomainEvent;
import net.chrisrichardson.ftgo.restaurantservice.events.MenuItem;
import net.chrisrichardson.ftgo.restaurantservice.events.RestaurantMenu;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

// TODO: 2020/8/4 不太清楚Restaurant的表结构
@Entity
@Table(name = "order_service_restaurants")
@Access(AccessType.FIELD)
public class Restaurant {

    @Id
    private Long id;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "order_service_restaurant_menu_items")
    private List<MenuItem> menuItems;
    private String name;

    private Restaurant() {
    }

    public Restaurant(long id, String name, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

    public List<OrderDomainEvent> reviseMenu(RestaurantMenu revisedMenu) {
        throw new UnsupportedOperationException();
    }

    public void verifyRestaurantDetails(TicketDetails ticketDetails) {
        // TODO - implement me
    }

    public Long getId() {
        return id;
    }

    public Optional<MenuItem> findMenuItem(String menuItemId) {
        return menuItems.stream().filter(mi -> mi.getId().equals(menuItemId)).findFirst();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getName() {
        return name;
    }
}
