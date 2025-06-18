const toggleButton = document.getElementById('theme-toggle');
const icon = toggleButton.querySelector('i');
const body = document.body;

// Cargar estado inicial
if (localStorage.getItem('theme') === 'dark') {
    body.classList.add('dark-mode');
    icon.classList.replace('fa-moon', 'fa-sun');
}

toggleButton.addEventListener('click', () => {
    body.classList.toggle('dark-mode');
    const dark = body.classList.contains('dark-mode');
    icon.classList.replace(dark ? 'fa-moon' : 'fa-sun', dark ? 'fa-sun' : 'fa-moon');
    localStorage.setItem('theme', dark ? 'dark' : 'light');
});