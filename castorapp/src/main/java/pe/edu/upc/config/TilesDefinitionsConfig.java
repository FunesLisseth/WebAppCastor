package pe.edu.upc.config;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;
import java.util.HashMap;
import java.util.Map;

public final class TilesDefinitionsConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<String,Definition>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/views/layout/main.jsp");

    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<String,Attribute>();

        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/views/layout/head.jsp"));
        attributes.put("menu", new Attribute("/views/layout/menu.jsp"));
        attributes.put("content", new Attribute(body));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    public static void addDefinitions(){

        addDefaultLayoutDef("clearPage.tiles", "CASTOR - Home", "/views/layout/body.jsp");
        addDefaultLayoutDef("articulosList.tiles", "CASTOR - Articulos", "/views/articulos/show.jsp");
        addDefaultLayoutDef("categoriasList.tiles", "CASTOR - Categorias", "/views/categorias/show.jsp");

    }
}