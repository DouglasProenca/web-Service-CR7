      document.getElementById('toggle-password').addEventListener('mousedown', function() {
	    document.getElementById('login-senha').type = 'text';
	  });

	  document.getElementById('toggle-password').addEventListener('mouseup', function() {
	    document.getElementById('login-senha').type = 'password';
	  });

	  // Para que o password não fique exposto apos mover a imagem.
	  document.getElementById('toggle-password').addEventListener('mousemove', function() {
	    document.getElementById('login-senha').type = 'password';
	  });