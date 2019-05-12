package dev.felipeaguiar.financeiro.interfaces.resource.util;

import java.net.URI;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;

@Component
public class ResourceHelper {

	@Autowired
	Validator validator;

	@Autowired
	private ObjectMapper mapper;

	private void validate(Object object) throws MethodArgumentNotValidException, NoSuchMethodException {
		String name = WordUtils.uncapitalize(object.getClass().getSimpleName());
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(object, name);
		validator.validate(object, result);

		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(new MethodParameter(object.getClass().getConstructor(), -1), result);
		}
	}

	public <T> T applyPatch(JsonPatch patch, T object, Class<T> clazz) throws MethodArgumentNotValidException {

		JsonNode objectJson = mapper.convertValue(object, JsonNode.class);

		try {
			JsonNode patchedNode = patch.apply(objectJson);
			T patchedObject = mapper.convertValue(patchedNode, clazz);
			validate(patchedObject);
			return patchedObject;
		} catch (MethodArgumentNotValidException e) {
			throw e;
		} catch (Exception e) {
			throw new HttpMessageConversionException(patch.toString(), e);
		}
	}

	public URI getUriOf(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
	}

}
